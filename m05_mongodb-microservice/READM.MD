1) starting mongodb docker image
2) adding mongodb database: go Mongo express  
http://localhost:8022/game; use admin:tribes, to login and create database with the name: game_shop_db
3) enjoy playing with api on the link: </br>
 POST  http://localhost:8022/game  </br>
Body:
<code>
   {
   "id" :"123",
   "name" : "The last of us",
   "price": 33
   }
</code>
4) To use any other mongodb client use the connection string <br>
   mongodb://admin:pass@localhost:27017/?authMechanism=DEFAULT
