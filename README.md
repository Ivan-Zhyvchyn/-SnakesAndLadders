# -SnakesAndLadders
Test task, implementation feature 1 ( http://agilekatas.co.uk/katas/SnakesAndLadders-Kata )

Service for playing ( roll dice and move token ) : 

curl --location --request POST 'localhost:8080/api/moving' \
--header 'Content-Type: application/vnd.api+json' \
--data-raw '{
    "playerId" : "human"
}'

Response example :

{
    "data": {
        "id": "0",
        "type": "games",
        "attributes": {
            "gamePlayers": {
                "Player{playerId='machine'}": {
                "tokenPosition": 1
                },
                "Player{playerId='human'}": {
                "tokenPosition": 3
            }
        },
            "winnerId": null
        }
    }
}