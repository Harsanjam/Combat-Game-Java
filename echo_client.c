#include <stdio.h>
#include <netdb.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <unistd.h>
#include <strings.h>
#include <fcntl.h> // Added for file operations
#include <netinet/in.h>

#define ErrorMsg	"File with name 'coe768lab3.txt' not found"
#define SERVER_TCP_PORT 3000
#define BUFLEN 256

int receivefile(int, char*); 

int main(int argc, char **argv) {
    int n, i, bytes_to_read;
    int sd, port;
    struct hostent *hp;
    struct sockaddr_in server;
    char *host, *bp, rbuf[BUFLEN], sbuf[BUFLEN];

    switch (argc) {
        case 2:
            host = argv[1];
            port = SERVER_TCP_PORT;
            break;
        case 3:
            host = argv[1];
            port = atoi(argv[2]);
            break;
        default:
            fprintf(stderr, "Usage: %s host [port]\n", argv[0]);
            exit(1);
    }

    if ((sd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        fprintf(stderr, "Can't create a socket\n");
        exit(1);
    }

    bzero((char *)&server, sizeof(struct sockaddr_in));
    server.sin_family = AF_INET;
    server.sin_port = htons(port);
    if ((hp = gethostbyname(host)) != NULL) { // Fixed condition
        bcopy(hp->h_addr, (char *)&server.sin_addr, hp->h_length);
    } else if (inet_aton(host, (struct in_addr *)&server.sin_addr)) {
        fprintf(stderr, "Can't get server's address\n");
        exit(1);
    }

    if (connect(sd, (struct sockaddr *)&server, sizeof(server)) == -1) {
        fprintf(stderr, "Can't connect\n");
        exit(1);
    }

    printf("Receiving the file -------\n");

    // promt user for the filename -
    //- into string -- pass string to the recieve file func
    
    char name[50];
    scanf("%s",name); 

    if (receivefile(sd, name) == -1) {
        fprintf(stderr, "Error trying to receive the file.\n");
    } else {
        printf("File found and received successfully.\n");
    }

    close(sd);
    return 0;
}

int receivefile(int sd, char* iname) {
    char buf[BUFLEN];
    int filefd, bread;
    char name[50];

	//sends the file name to the socket 
	//strcpy(name, iname); 
    	write(sd, iname, 50);

	//CHECK RECEIVED MESSAGE
	int temp, val;
	read(sd, &temp, sizeof(temp));
	val = ntohl(temp);
    if(val == -1){
		printf("FILE NAME SENT NOT FOUND\n");
		return -1;
	}
	
	filefd = open(name, O_WRONLY | O_CREAT, 0666); // Changed fopen to open
	if (filefd == -1) {
	    fprintf(stderr, "Error creating file\n");
	    return -1;
	}

	while ((bread = read(sd, buf, BUFLEN)) > 0) {
	    if (write(filefd, buf, bread) != bread) {
	        fprintf(stderr, "Error trying to write to the file\n");
	        close(filefd);
	        return -1;
	    }
	}

	close(filefd);
	return 0;
}

