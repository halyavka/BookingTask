# BookingTask

 Open terminal and go to the directory: 
```bash
cd BookingTask
```
 Run selenoid + selenoid-ui via docker command: 
```bash
docker-compose up
```

You can open http://localhost:8083/#/ and check if selenoid works

 For build project run command: 
```bash
./gradlew build -Dskip.tests=true
```
 Build docker image: 
```bash
docker build -t booking_task:1.0.1 .
```
 Run docker image: 
```bash
docker run --network=host booking_task:1.0.1
```