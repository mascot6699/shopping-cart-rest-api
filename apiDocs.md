`API docs
===========

* These are the apis that are *not* self documented in swagger.

##### For login

###### As admin user
`curl -u rest_api_client_normal_user:top_secret -X POST http://localhost:8080/oauth/token -H "Accept:application/json" -d "username=umang&password=umang&grant_type=password"`

###### As normal user
`curl -u rest_api_client_normal_user:top_secret -X POST http://localhost:8080/oauth/token -H "Accept:application/json" -d "username=normal1&password=aaaaaaaaa&grant_type=password"`


* These apis are documented in swagger too. 
* Listing here sample curls as right now not able to send request as no place to give access token. [ ] Solved
* Everywhere we need to replace "XXX-token-XXX" with token received.

###### List an item
Accessed by normal user and admin user

`curl -H "Authorization: Bearer XXX-token-XXX" http://localhost:8080/v1/items`

###### Read particular item
Accessed by normal user and admin user

`curl -H "Authorization: Bearer XXX-token-XXX" http://localhost:8080/v1/items/1`

###### Create new user
`curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -H "Authorization: Bearer XXX-token-XXX" -d '{ 
   "first_name": "string",
   "last_name": "string",
   "password": "string",
   "user_name": "normal1"
 }' 'http://localhost:8080/v1/user'`

