Feature:Verif verivication de menu 
Scenario: client click sur le menu pour diriger vers le produit
Given  utlisateur est dans la page  daccueil 
When lutilisateur est cliquer sur le menu "Nouveautés" et cliquer sur submenu "Life in jogg."
Then utlisateur est dirige vers la page  "Life in jogg."

