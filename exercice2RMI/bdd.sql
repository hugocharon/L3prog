drop table if exists Utilisateur;
create table Utilisateur
	(
		nom varchar(20) primary key,
		mdp varchar(20) not null
	);