// Indexes
db.users.createIndex({"userName": 1}, {unique: true})

// Inserts
db.users.insert({"userName": "michael_lysaght", "password": "1234"});
db.users.insert({"userName": "oleksii_iepishkin", "password": "4321"});
db.users.insert({"userName": "michail_gorbachev", "password": "4321"});