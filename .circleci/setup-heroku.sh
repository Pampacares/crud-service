#!/bin/bash

wget -qO- https://cli-assets.heroku.com/install-ubuntu.sh | sh

cat > ~/.netrc << EOF
machine api.heroku.com
  login igordalepiane@gmail.com
  password 4fa609ea-7634-4aab-acfc-d4ee72612b2b
machine git.heroku.com
  login igordalepiane@gmail.com
  password 4fa609ea-7634-4aab-acfc-d4ee72612b2b
EOF

heroku git:remote -a $HEROKU_APP
