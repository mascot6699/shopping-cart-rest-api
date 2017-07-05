API docs
===========

These are the apis that are not self documented in swagger.


###### For login
`curl -u rest_api_client_normal_user:top_secret -X POST http://localhost:8080/oauth/token -H "Accept:
application/json" -d "username=umang&password=umang&grant_type=password"`

curl http://localhost:8080/v1/items -H "Authorization: Bearer fdcc62aa-b4bb-4668-a8da-67905f222c6a"
