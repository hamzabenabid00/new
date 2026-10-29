Feature:Verif produit dans la collection
Scenario: client clique sur le produit et verifier la page de produit
  Given utilisateur est dans la page collection
  When lutilisateur clique sur le produit "Pantalon straight 100% lin - bleu foncé"
  Then utlisateur est dirige vers la page produit "Pantalon straight 100% lin - bleu foncé"
