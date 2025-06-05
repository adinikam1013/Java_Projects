CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  account_type VARCHAR(20),
  balance DOUBLE,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Default test data
INSERT INTO users (username, password, role) VALUES
('user1', '{noop}password1', 'ROLE_USER'),
('admin1', '{noop}adminpass', 'ROLE_ADMIN');

INSERT INTO accounts (user_id, account_type, balance) VALUES
(1, 'savings', 1000.00),
(2, 'current', 5000.00);
