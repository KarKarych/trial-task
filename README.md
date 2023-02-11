# Trial task 
#### Backend application

API allow:
- Register and authorization via Spring Security (JWT token) 
- Updating and deleting an authorized user
- Get top 10 quotes
- Get flop 10 quotes
- Get random quote
- Get last quotes with pagination
- Get last user quotes with pagination by an authorized user
- Save, update, delete quote by an authorized user
- Upvote, downvote the quote, edit/delete quote rating by an authorized user
- Get count up and downvotes for each day from the date of quote creation and up to the current moment

More detailed  on [OpenApi specification](https://gitlab.com/smetaninivanu/openapi/-/blob/main/openApi.yaml)

Used technologies: 
- Spring Boot 3.0
- Spring Data JPA, Spring Validation
- Spring Security, Java JWT
- Mapstruct
- Springdoc OpenApi
- Liquibase
- H2
- Lombok
- Gradle
- Docker

Link to [Dockerhub](https://hub.docker.com/repository/docker/wvolfff/kameleoon-trial)
