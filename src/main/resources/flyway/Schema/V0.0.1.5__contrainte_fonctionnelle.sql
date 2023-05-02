ALTER TABLE personnes
ADD departement_id int,
ADD CONSTRAINT fk_departement_id FOREIGN KEY (departement_id) REFERENCES departements(id);