// 1
MATCH (p:Person)
  WHERE p.name = 'Alexandr Klecevich'
RETURN p;

// 2
MATCH (person)-[:LIKE]->(language)
  WHERE person.name = 'Denis Timofeenko'
RETURN language;

// 3
MATCH (person)-[l:LIKE]->(language)
  WHERE language.name = 'C++' AND l.rating > 0
RETURN person.name;

// 4
MATCH (person2)-[:FRIEND]->(person)-[l:LIKE]->(language:Language)
  WHERE sport.name = 'Java Script' AND l.rating >= 8
RETURN DISTINCT person2.name;

// 5
MATCH (person2)-[:FRIEND]->(person)-[l:LIKE]->(language:Language)
  WHERE person2.name = 'Alexandr Klecevich' AND l.rating > 6
  AND NOT (person2)-[:LIKE]->(language:Language)
RETURN language;


// 6
MATCH (person)-[:FRIEND]->(friend)
RETURN DISTINCT friend;

// 7
MATCH ()-[l:LIKE]->(language:Language)
  WHERE l.rating = 8
RETURN DISTINCT language;

// 8
MATCH (person)-[l:LIKE]->(language)
  WHERE person.name = 'Alexandr Klecevich' AND l.rating > 0
RETURN language;

// 9
MATCH (person)-[l:LIKE]->(language)
  WHERE sport.name = 'Python' AND l.rating > 0
RETURN person;

// 10
MATCH (person)-[l:LIKE]->(language:Language)
  WHERE l.rating < 0
RETURN person.name, language.name, l.rating;

