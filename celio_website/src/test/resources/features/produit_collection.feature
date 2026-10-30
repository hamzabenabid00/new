Feature: Verification de la redirection vers le produit

Scenario: client click sur le produit et verifie la redirection
  Given utilisateur est sur la page collection
  When lutilisateur clique sur le produit "T-shirt regular 100% coton manches longues - vert"
  Then utlisateur est redirige vers la page produit "T-shirt regular 100% coton manches longues - vert"

