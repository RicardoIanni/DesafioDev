Primeiramente as bases estariam separadas em containers distintos, configurados conforme necessidade de segurança: Base A, isolamento máximo com necessidade de autenticação via certitifcado digital além de HTTPS com limite de acesso simultâneo; Base B,  também teria o mesmo nível de segurança, com autenticação via certificado digital e utilização de HTTPS, mas com um limite maior de acessos simultâneos; e a Base C, utilizaria apenas acesso HTTPS sem limite de acesso simultâneo.

Com relação ao acesso e trafego de informações entre as 3 bases e a aplicação principal, desenvolvi algo simples, como uma forma de esboço da solução, onde teriam serviços em casa um das bases que seria acessados via REST. O fonte desenvolvido seria uma idéia de backend, utilizando Java, Spring, Lombok e MySQL.

Para o Frontend usaria algo como React, com NodeJS e Bootstrap, para ter boa responsividade nas diversas possibildades de acesso ao app principal.
