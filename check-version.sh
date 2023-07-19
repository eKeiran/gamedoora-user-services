#!/bin/bash

VERSION=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
URL=https://maven.pkg.github.com/gamedoora/gamedoora-user-services/com/gamedoora/backend/gamedoora-user-services/$VERSION/gamedoora-user-services-$VERSION.pom
STATUS_CODE=$(curl --silent --output /dev/null --write-out "%{http_code}\n" -u ${USER}:${PAT} $URL)

if [ "$STATUS_CODE" -eq 404 ]; then
  echo "::set-output name=exists::false"
  echo "Version $VERSION does not exist, proceeding with the artifact upload."
else
    echo "::set-output name=exists::true"
    echo "Version $VERSION already exists."
fi
