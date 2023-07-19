#!/bin/bash

JAR_FILE=target/*.jar
REMOTE_DIRECTORY=/home/ec2-user/server/user-services
REMOTE_JAR_FILE=user-services.jar

# Create a temporary SSH key file
echo "$SSH_KEY" > /tmp/gamedoora-dev.pem
chmod 600 /tmp/gamedoora-dev.pem
cat /tmp/gamedoora-dev.pem
echo $SSH_USERNAME
echo $SSH_HOST

# connect to the EC2 instance and set up the remote directory
ssh -i "/tmp/gamedoora-dev.pem" -o StrictHostKeyChecking=no "$SSH_USERNAME@$SSH_HOST" "
  if [ -d $REMOTE_DIRECTORY ]; then
    cd $REMOTE_DIRECTORY
    if [ -f $REMOTE_JAR_FILE ]; then
      pkill -f $REMOTE_JAR_FILE
      rm -f $REMOTE_JAR_FILE
    fi
  else
    mkdir -p $REMOTE_DIRECTORY
  fi"

# copy the new JAR file to the remote directory and rename it
scp -i "/tmp/gamedoora-dev.pem" -o StrictHostKeyChecking=no $JAR_FILE "$SSH_USERNAME@$SSH_HOST:$REMOTE_DIRECTORY/$REMOTE_JAR_FILE"

# make the new JAR file executable and start the new service
ssh -i "/tmp/gamedoora-dev.pem" -o StrictHostKeyChecking=no "$SSH_USERNAME@$SSH_HOST" "
  cd $REMOTE_DIRECTORY
  chmod +x $REMOTE_JAR_FILE
  sudo java -jar -Dserver.port=8081 $REMOTE_JAR_FILE > user_service.log 2> user_service.error.log &"

# Remove the temporary SSH key file
rm /tmp/gamedoora-dev.pem

# Check the exit status of the previous command and set an output variable accordingly
if [ $? -eq 0 ]; then
  echo "::set-output name=status::success"
else
  echo "::set-output name=status::failure"
fi