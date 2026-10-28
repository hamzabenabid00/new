Feature:Verif le produit dans le panier
Scenario: ajout produit dans le panier
When  utlisateur est dans la page  produit 
When lutilisateur est cliquer sur le couleur "noire" et clique sur la taille "S" et cliquer sur ajout au panier
Then utlisateur est dirige vers la page panier et verifier lajout de produit "Blouson Drycore à capuche mi-saison - noir"

