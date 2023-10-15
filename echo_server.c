#include <stdio.h>
#include <sys/types.h>
#include <sys/unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/signal.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <strings.h>
#include <string.h>
#include <fcntl.h>
#include <netinet/in.h>

#define SERVER_TCP_PORT 3000	/* well-known port */
#define BUFLEN		256	/* buffer length */
//making the file 
#define FILENAME	"lab3.txt"
#define ErrorMessage	"File with name 'lab3.txt' not found"

void reaper(int);
int sfile(int);

int main(int argc, char **argv){
	int 	sd, new_sd, client_len, port;
	struct	sockaddr_in server, client;

	switch(argc){
	case 1:
		port = SERVER_TCP_PORT;
		break;
	case 2:
		port = atoi(argv[1]);
		break;
	default:
		fprintf(stderr, "Usage: %s [port]\n", argv[0]);
		exit(1);
	}

	/* Create a stream socket	*/	
	if ((sd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
		fprintf(stderr, "Can't creat a socket\n");
		exit(1);
	}

	/* Bind an address to the socket	*/
	bzero((char *)&server, sizeof(struct sockaddr_in));
	server.sin_family = AF_INET;
	server.sin_port = htons(port);
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	if (bind(sd, (struct sockaddr *)&server, sizeof(server)) == -1){
		fprintf(stderr, "Can't bind name to socket\n");
		exit(1);
	}

	/* queue up to 5 connect requests  */
	listen(sd, 5);

	(void) signal(SIGCHLD, reaper);

	while(1) {
	  client_len = sizeof(client);
	  new_sd = accept(sd, (struct sockaddr *)&client, &client_len);
	  if(new_sd < 0){
	    fprintf(stderr, "Can't accept client \n");
	    exit(1);
	  }
	  switch (fork()){
	  case 0:		/* child */
		(void) close(sd);
		exit(sfile(new_sd));
	  default:		/* parent */
		(void) close(new_sd);
		break;
	  case -1:
		fprintf(stderr, "fork: error\n");
	  }
	}
}


/*	reaper		*/
void	reaper(int sig){
	int	status;
	while(wait3(&status, WNOHANG, (struct rusage *)0) >= 0);
}

//file sending function
int sfile (int sd){
	char buf[BUFLEN];
	int fild, br;
	char fname[BUFLEN];
	int z; 

	z = read(sd, buf, BUFLEN);
	strcpy(fname,buf);  //= buf; 

	//opening the file
	fild = open(fname, O_RDONLY);
	if(fild == -1){
		printf("File NOT found/n");
		int temp = htonl(fild);
		write(sd, &temp, sizeof(temp));
		return -1;
	}
	while((br = read(fild, buf, BUFLEN)) >0 ){
		if(write(sd, buf, br) != br){
			fprintf(stderr, "error sending the file");
			close(fild);
			return -1;
		}
	} 
	close(fild);
	return 0;
}
