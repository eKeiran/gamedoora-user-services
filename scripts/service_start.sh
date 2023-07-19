#!/usr/bin/env bash
mkdir -p /home/ec2-user/server/user-services
cd /home/ec2-user/server/user-services || exit
sudo java -jar -Dserver.port=8081 \
    *.jar > user_service.log 2> user_service.error.log &
