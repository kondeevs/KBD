CREATE (alex_klecevich:Person {name: 'Alexandr Klecevich', age : 19, email: 'alex_klevcevich@gmail.com'}),
(denis_timofeenko:Person {name: 'Denis Timofeenko' , age : 19, email: 'denis_timofeenko@gmail.com'}),
(yauheni_kazachenka:Student {name: 'Yauheni Kazachenka' , age : 20, email: 'yauheni_kazachenka@mail.ru'})

CREATE (java: Language{name: 'Java', type:'Programming Language'}),
(js: Language{name: 'Java Script', type: 'Programming Language'}),
(sql: Language{name: 'MySQL', type: 'Database Service'}),
(python: Language{name: 'Python', type: 'Programming Language'}),
(c++: Language{name: 'C++', type: 'Programming Language'}),

(alex_klecevich)-[:LIKE {rating: 10}]->(java),
(alex_klecevich)-[:LIKE {rating: -5}]->(js),
(alex_klecevich)-[:LIKE {rating: 8}]->(sql),
(alex_klecevich)-[:LIKE {rating: 7}]->(python),
(alex_klecevich)-[:LIKE {rating: 7}]->(c++),

(yauheni_kazachenka)-[:LIKE {rating: 7}]->(java),
(yauheni_kazachenka)-[:LIKE {rating: 7}]->(js),
(yauheni_kazachenka)-[:LIKE {rating: 8}]->(sql),
(yauheni_kazachenka)-[:LIKE {rating: -4}]->(python),
(yauheni_kazachenka)-[:LIKE {rating: -6}]->(c++),

(denis_timofeenko)-[:LIKE {rating: 9}]->(java),
(denis_timofeenko)-[:LIKE {rating: 3}]->(js),
(denis_timofeenko)-[:LIKE {rating: 8}]->(sql),
(denis_timofeenko)-[:LIKE {rating: 5}]->(python),
(denis_timofeenko)-[:LIKE {rating: 7}]->(c++),

(alex_klecevich)-[:FRIEND]->(denis_timofeenko),
(alex_klecevich)-[:FRIEND]->(yauheni_kazachenka),
(alex_klecevich)<-[:FRIEND]-(denis_timofeenko),
(alex_klecevich)<-[:FRIEND]-(yauheni_kazachenka),
(denis_timofeenko)-[:FRIEND]->(yauheni_kazachenka),
(denis_timofeenko)<-[:FRIEND]-(yauheni_kazachenka)
