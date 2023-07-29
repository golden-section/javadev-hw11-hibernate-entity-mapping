INSERT INTO client (name) VALUES
  ('Theodore Lamb'),
  ('Inaaya Valentine'),
  ('Keith Joseph'),
  ('Oskar Matthews'),
  ('Kamil Rollins'),
  ('Kacper Andrade'),
  ('Amir Wright'),
  ('Ali Meyers'),
  ('Rayhan Duran'),
  ('Bessie Mcgee'),
  ('Olivier Dyer'),
  ('Hayley Wiggins');

INSERT INTO planet (id, name) VALUES
  ('MER', 'Mercury'),
  ('VEN', 'Venus'),
  ('EAR', 'Earth'),
  ('MAR', 'Mars'),
  ('JUP', 'Jupiter'),
  ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
  (CURRENT_TIMESTAMP, 1, 'MER', 'VEN'),
  (CURRENT_TIMESTAMP, 2, 'VEN', 'MAR'),
  (CURRENT_TIMESTAMP, 3, 'EAR', 'SAT'),
  (CURRENT_TIMESTAMP, 4, 'MAR', 'VEN'),
  (CURRENT_TIMESTAMP, 5, 'SAT', 'EAR'),
  (CURRENT_TIMESTAMP, 6, 'JUP', 'VEN'),
  (CURRENT_TIMESTAMP, 7, 'VEN', 'SAT'),
  (CURRENT_TIMESTAMP, 8, 'MER', 'SAT'),
  (CURRENT_TIMESTAMP, 9, 'SAT', 'EAR'),
  (CURRENT_TIMESTAMP, 10, 'EAR', 'JUP');