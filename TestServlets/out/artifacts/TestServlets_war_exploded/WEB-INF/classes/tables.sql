CREATE TABLE users (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  login VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE products (
  id INT NOT NULL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  price NUMERIC NOT NULL,
  specification VARCHAR(255),
  users_id INT NOT NULL ,
  FOREIGN KEY (users_id) REFERENCES users(id)
);
INSERT INTO users (id,name,email,login,password) VALUES(1, 'Timur', 'tima@mail','Timurmartat', '890')