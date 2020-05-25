### I Téléchargements des outils et logiciels nécessaires

Pour déployer l'application vous aurez besoin des logiciels suivants : Java et JDK, Apache Tomcat, Apache Maven, PostgreSQL. Pour ce faire, créez vous un dossier nommé « projet7 » par exemple sur le bureau afin d’y mettre les logiciels nécessaires au déploiement.

### II Déploiement de la base de données

Dans le dossier d'installation de PostgreSQL, lancez l'application pgAdmin4. Le chemin est le suivant : PostgreSQL\10\pgAdmin4\bin.

Pour commencer, vous devez établir une connexion à un nouveau serveur. Dans le menu, cliquez sur l'icone représentant une prise. Donnez un nom à cette connexion (ex: localhost_demo) et renseignez comme hôte "localhost"(adresse IP configuré dans le serveur PostgreSQL). Pour le port, renseignez 5432.

Vous devez ensuite créer un utilisateur. Cliquez sur "Role de connexion", clic droit -> Role de connexion. Renseignez un nom de rôle et dans l'onglet Définition vous devrez renseignez un mot de passe.

Vous pouvez désormais créer la base de donnée. Faites un clic droit sur "Bases de données" --> ajouter une base de donnée. Renseignez un nom et le propriétaire (utilisateur crée à l'étape précédente) puis validez.

Déroulez la nouvelle base de données pour afficher son contenu. Faite un clic droit sur "public" puis dans la liste proposée sélectionnez "Create Script".

Retournez sur github au niveau du repository « P7_Web-Service_Bibliotheque », cliquez sur le bouton Clone or Download puis sur Download ZIP.

Dézipper le dossier et allez dans le dossier « base_de_données ».

Faites un clic droit sur le fichier « db_bibliotheque.sql" et ouvrez le avec un éditeur de texte. Copiez le contenu et collez le dans l'éditeur de pgAdmin.

Cliquez ensuite sur l'icône dans la barre de tâches qui ressemble à un éclair.

Vous deviez voir ce message apparaître si l’opération s’est déroulé correctement : « Query returned successfully in 10 secs 308 msec. ».

Répétez ce processus avec le fichier « jeu_de_données.dsl ».

Maintenant que vous avez crée la base de donnée, il va falloir déployer l'application.

### III Déploiement de l’application

Retournez dans le dossier « P7_Web-Service_Bibliotheque » et ouvrez le dossier « bibliotheque » (C’est ce dossier qui contient le web service de l’application). Copiez le chemin qui pointe vers ce dossier.

Nous allons utiliser Maven pour créer notre .jar pour la partie web-service.

Ouvrez votre invite de commande, tapez la commande cd suivi du chemin copié à l'étape précédente. Faites entrer.

Entrez la commande mvn package afin d'empaqueter l'application. Ensuite via le terminal, rendez vous dans le dossier target en suivant le chemin suivant : P7_Web-Service_Bibliotheque-master\bibliotheque\target. Faites entrer.

Saisissez ensuite la commande suivante : java –jar bibliotheque.jar Rendez vous ensuite dans le dossier « webapplication », copiez le chemin qui pointe vers ce dossier.

Nous allons utiliser Maven pour créer le war de l’application web et le jar du batch. En ligne de commande, saisissez la commande cd puis collez le chemin qui pointe vers le dossier de l’application web. Faites entrer. Saisissez ensuite la commande mvn package afin d’empaqueter l’application web. Rendez vous dans le dossier « P7_Web-Service_Bibliotheque » puis ouvrez le dossier « webapplication » puis dans le dossier target. Copiez le fichier « webapplication.war » et collez le dans le dossier « webapps » de Apache Tomcat.

Pour lancer le serveur Tomcat, revenez dans le dossier précédent et ouvrez le dossier bin. Double cliquez sur le fichier startup. Une invite de commande va s'ouvrir et Tomcat va se lancer. Ouvrez votre navigateur et entrez l'URL suivante : http://localhost:8085

### IV Lancement du batch

Pour lancer le batch, placez vous dans le dossier « webapplication » puis dans le dossier « batch » et enfin dans le dossier target.

Ouvrez votre invite de commande et collez le chemin suivant : P7_Web-Service_Bibliotheque \ webapplication \ batch \ target > java –jar batch.jar



