INSERT INTO Ville (nom, code_postal, slug, image) VALUES ('Paris', '75000', 'paris', 'paris.jpg'),
                                                     ('London', 'SW1A 1AA', 'london', 'london.jpg'),
                                                     ('New York', '10001', 'new-york', 'new-york.jpg');
INSERT INTO Centre (version, CREATED_AT, UPDATED_AT, nom, adresse, tel, email, ville_id)
VALUES
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'Centre A', 'Address A', '123456789', 'email@domain.com', 1),
    ('1.1', '2023-11-23 00:00:00', '2023-11-23 00:00:00', 'Centre B', 'Address B', '987654321', 'email2@domain.com', 2),
    ('1.2', '2023-11-24 00:00:00', '2023-11-24 00:00:00', 'Centre C', 'Address C', '555555555', 'email3@domain.com', 1),
    ('1.3', '2023-11-25 00:00:00', '2023-11-25 00:00:00', 'Centre D', 'Address D', '777777777', 'email4@domain.com', 2);


INSERT INTO responsable_rayon (version, CREATED_AT, UPDATED_AT, nom, prenom, email, password, username, centre_id)
VALUES
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'John', 'Doe', 'john@example.com', 'password123', 'johnny', 1),
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'Alice', 'Smith', 'alice@example.com', 'pass456', 'alice', 2),
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'Bob', 'Johnson', 'bob@example.com', 'pass789', 'bob', 3),
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'Emma', 'Davis', 'emma@example.com', 'pass321', 'emma', 1),
    ('1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00', 'Mike', 'Wilson', 'mike@example.com', 'pass987', 'mike', 1);
INSERT INTO Categorie (id,nom, description, image, slug)
VALUES
    (1, 'Category A', 'Description A', 'image_url_a.jpg', 'category-a'),
    (3, 'Category B', 'Description B', 'image_url_b.jpg', 'category-b'),
    (2, 'Category C', 'Description C', 'image_url_c.jpg', 'category-c');
-- Add more INSERT INTO statements for additional categories
-- INSERT INTO rayon (nom, description, image, slug, categorie_id, responsable_rayon_id, centre_id, version, CREATED_AT, UPDATED_AT)
-- VALUES
--     ('Name 1', 'Description 1', 'image1.jpg', 'slug1', 1, 1, 1, 'version1', '2023-11-26 12:00:00', '2023-11-26 12:00:00'),
--     ('Name 2', 'Description 2', 'image2.jpg', 'slug2', 2, 2, 2, 'version2', '2023-11-26 12:00:00', '2023-11-26 12:00:00'),
--     -- Add more rows here
--     ('Name n', 'Description n', 'imagen.jpg', 'slugn', 1, 1, 1, 'versionn', '2023-11-26 12:00:00', '2023-11-26 12:00:00');

INSERT INTO Rayon (nom, description, image, slug, categorie_id, responsable_rayon_id, centre_id, version, CREATED_AT, UPDATED_AT)
VALUES
    ('Rayon A', 'Description A', 'image_url_a.jpg', 'rayon-a', 1, 1, 1, '1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00'),
    ('Rayon B', 'Description B', 'image_url_b.jpg', 'rayon-b', 2, 3, 1, '1.1', '2023-11-23 00:00:00', '2023-11-23 00:00:00'),
    ('Rayon C', 'Description C', 'image_url_c.jpg', 'rayon-c', 3, 2, 1, '1.2', '2023-11-24 00:00:00', '2023-11-24 00:00:00');

INSERT INTO Produit (nom, description, image, prix, quantite, categorie_id, version, CREATED_AT, UPDATED_AT)
VALUES
    ('Product A', 'Description A', 'image_url_a.jpg', 10.99, 100, 1, '1.0', '2023-11-22 00:00:00', '2023-11-22 00:00:00'),
    ('Product B', 'Description B', 'image_url_b.jpg', 19.99, 50, 2, '1.1', '2023-11-23 00:00:00', '2023-11-23 00:00:00'),
    ('Product C', 'Description C', 'image_url_c.jpg', 15.50, 75, 1, '1.2', '2023-11-24 00:00:00', '2023-11-24 00:00:00'),
    ('Product D', 'Description D', 'image_url_d.jpg', 29.75, 30, 3, '1.3', '2023-11-25 00:00:00', '2023-11-25 00:00:00'),
    ('Product E', 'Description E', 'image_url_e.jpg', 22.00, 90, 2, '1.4', '2023-11-26 00:00:00', '2023-11-26 00:00:00');
