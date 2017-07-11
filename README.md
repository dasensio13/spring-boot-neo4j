# spring-boot-neo4j
Repository to demonstrate a possible issue in neo4j library

# Steps to reproduce
Just launch ActorRepositoryTests.findActor test

After actorRepository.findOne, _actor_ has only one relationship in _playedIn_ collection

# Issue open on github
I have opened an [issue](https://github.com/neo4j/neo4j-ogm/issues/385) in neo4j-ogm repository

Thanks to @vince-bickers, my problem is solved by changing the relationship from _Collection_ to _List_ but I think it's still an issue in the library.

# Question on stackoverflow
Also I have asked it on [stackoverflow](https://stackoverflow.com/questions/45015698/spring-data-neo4j-graphrepository-findone-doesnt-retrieve-all-the-relationships)
