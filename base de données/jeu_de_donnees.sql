

INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (18, '2020-01-29', '2020-02-26', false, 1, 2, false, false);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (19, '2020-01-29', '2020-02-26', false, 1, 5, false, false);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (2, '2019-11-15', '2020-01-15', true, 1, 3, false, true);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (9, '2020-01-23', '2020-02-20', false, 1, 6, false, true);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (10, '2020-01-23', '2020-02-20', false, 1, 5, false, true);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (1, '2019-10-21', '2019-12-21', true, 1, 1, true, true);
INSERT INTO public.emprunt (id, date_debut, date_fin, prolongation, membreid, exemplaireid, relance, termine) VALUES (3, '2020-01-06', '2020-02-06', false, 1, 4, false, true);



INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (1, true, 1);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (6, true, 4);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (3, true, 2);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (2, false, 1);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (5, false, 4);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (4, true, 1);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (7, true, 5);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (8, true, 5);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (9, true, 6);
INSERT INTO public.exemplaire (id, disponibilite, livreid) VALUES (10, true, 6);




INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (3, 'Bel ami', 'Guy de Maupassant', 'Roman', '1885-01-01', 'Georges Duroy est un ancien sous-officier du 6e régiment des hussards ayant passé des années en Algérie, qui travaille dorénavant dans les chemins de fer à Paris. Très dépensier, il peine à joindre les deux bouts, mais retrouve par hasard un ancien camarade de régiment, Charles Forestier. Attristé par la situation de Duroy, Forestier, rédacteur au journal La Vie Française, l''engage comme journaliste et l''invite à une soirée mondaine chez lui. ', 'belami.jpg');
INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (2, 'Ecosysteme', 'Rachel Vanier', 'Roman', '2017-10-05', 'Marianne et Lucas sont les anti-héros de l''entrepreneuriat. Ils ont sauté le pas de la création d''entreprise, rêve de toute une génération de banquiers fatigués et de consultants blasés qui espèrent trouver dans les start-up le sens perdu dans leurs études à rallonge.', 'ecosysteme.jpg');
INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (4, 'Berezina', 'Sylvain Tesson', 'Récit voyage', '2017-05-10', 'Tout commence en 2012 : Sylvain Tesson décide de commémorer à sa façon le bicentenaire de la retraite de Russie. Refaire avec ses amis le périple de la Grande Armée, en side-car! De Moscou aux Invalides, plus de quatre mille kilomètres d''aventures attendent ces grognards contemporains.', 'berezina.jpg');
INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (5, 'Voyage au bout de la nuit', 'Louis Ferdinand Céline', 'Roman', '1932-01-01', 'Voyage au bout de la nuit est un récit à la première personne dans lequel le personnage principal raconte son expérience de la Première Guerre mondiale, du colonialisme en Afrique, des États-Unis de l''entre-deux guerres et de la condition sociale en général.', 'celine.jpg');
INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (6, 'Sur la route', 'Jack Kerouac', 'Récit voyage', '1957-01-01', 'Le roman raconte de manière quasi autobiographique les aventures de l''auteur (nommé Sal Paradise dans le livre) et d''un compagnon de route, Neal Cassady (nommé Dean Moriarty dans le roman). ', 'surlaroute.jpg');
INSERT INTO public.livre (id, titre, auteur, genre, date_publication, resume, url_photo) VALUES (1, 'Et j''ai suivi le vent', 'Anne France Dautheville', 'Récit voyage', '2017-05-10', 'C''était en 1972. Seule femme sur 92 pilotes, Anne-France Dautheville, 28 ans, participe à un raid moto entre Paris et Ispahan. Depuis l''Iran, elle poursuit en Afghanistan avec onze motards, puis au Pakistan avec quatre.', 'levent.png');



INSERT INTO public.membre (id, nom, prenom, adresse_mail, mot_de_passe, telephone, adresse, code_postal, ville) VALUES (4, 'Viloutreix', 'Pierre', 'pierrevilou@gmail.com', 'test', '0645873523', '3 impasse du Clos Jargot', '87000', 'Limoges');
INSERT INTO public.membre (id, nom, prenom, adresse_mail, mot_de_passe, telephone, adresse, code_postal, ville) VALUES (5, 'Mercier', 'Olivia', 'oliviamercier@gmail.com', 'test', '0629543932', '16 route de la Tuilière', '87220', 'AUREIL');
INSERT INTO public.membre (id, nom, prenom, adresse_mail, mot_de_passe, telephone, adresse, code_postal, ville) VALUES (7, 'Joffrey', 'Hernandez', 'joffreyhernandez@gmail.com', 'test', '0623764534', '31 avenue Jean Jaures', '31000', 'Toulouse');
INSERT INTO public.membre (id, nom, prenom, adresse_mail, mot_de_passe, telephone, adresse, code_postal, ville) VALUES (6, 'Dsh', 'Matthieu', 'matthieudesainthilaire@gmail.com', 'test', '0745947634', 'La Boisserie', '87000', 'Peyrilhac');
INSERT INTO public.membre (id, nom, prenom, adresse_mail, mot_de_passe, telephone, adresse, code_postal, ville) VALUES (1, 'Mercier', 'Pierre', 'pierremercier4@gmail.com', '123456', '0629543932', '3 rue Verdières', '17000', 'La Rochelle');




