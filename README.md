**OBS: This is a project to practice and demonstrate my skills in Java API development**

**ENDPOINTS:**

**LOGIN**: "/login": Ex:
```
{
	“email”: “rafa@hotmail.com”
	“password”: “123”
}
```
**REFRESH TOKEN**: "/auth/refresh_token"

**USER**: /users

**GET**

- "/users": return all users 
- "/users/{id}" : return specific  user
- "/users/{id}/data" : return additional data from a specific user

**POST**
- "/users":
```
{
          "username": "test",
          "email": "test@example.com",
          "password": "test"
}
```
- "/users/{id}/data": 
```
{
    "country": "Brazil",
    "state": "Pernambuco",
    "city": "Caruaru",
    "favoriteSong": "Shine on crazy Diamond",
    "favoriteAlbum": "Dark side to the moon",
    "favoriteBand": "Alter bridge",
    "favoriteMusicGenres": [3,19]
}
```

**PUT**

- "/users/{id}" : update specific  user
- "/users/{id}/data" : update additional data from a specific user


**DELETE**

- "/users/{id}" : delete specific  user
- "/users/{id}/data" : delete additional data from a specific user


**SONG**: /songs

**GET**

- "/songs": return all songs 
- "/songs/{id}" : return specific  song

**POST**
- "/songs":
```
{
          "name": "test",
          "album": "test",
          "band": "test",
          "year": "2020",
          "genre": "rock",
          "review": "I like this music because it's rocks!!"
}
```


**PUT**

- "/songs/{id}" : update specific  song

**DELETE**

- "/songs/{id}" : delete specific  song

