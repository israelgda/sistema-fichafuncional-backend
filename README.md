# sistema-fichafuncional-backend
Repositório do Webservice que irá fornecer o backend para o projeto de criação do sistema de controle de Fichas Funcionais da SEFAZ. Webservice criado com Java, Springboot, em arquitetura REST.

## Sobre o projeto

### Objetivo
Este projeto foi criado com o objetivo de trazer uma melhoria no processo de criação, edição e manutenção de fichas funcionais dos servidores da Secretaria da Fazenda do Estado de Alagoas, trazendo mais segurança, agilidade e organização no trabalho realizado diretamente com as fichas, que atualmente feitas e mantidas em arquivos de formato do Word, do pacote MS Office.

### Funcinalidades
####  - Das Fichas Funcionais - 
* Cadastro e edição fichas funcionais;
* Cadastro e edição dos dependentes vinculados as fichas funcionais;
* Endpoint centralizado para consulta de fichas com filtros por: Nome, Setor, Status;
* Visualização de todas as anotações atreladas à ficha;

#### - Das Anotações - 
* Cadastro e edição anotações nas fichas;
* Endpoint para cadastro de anotações que sejam replicadas em mais de uma ficha funcional, facilitanto o cadastro de forma única em multiplas fichas;
* Organização no cadastro dos dados da anotação, como: Descrição, data do DOE e Tipo da anotação;
* Possibilidade de filtragem das anotações por tipo: Férias, Aposentadoria, Afastamentos, Licenças e outros;
* Visualização de fichas atreladas por anotação;

#### - Dos dependentes - 
* Cadastro e edição dos dependentes atrelados às fichas;
* Visualização centralizada de todos os dependentes a fins de geração de relatórios futuros;

## Tecnologias utilizadas
#### - Framework - 
* Backend desenvolvido com Spring Framework

#### - Linguagens - 
* JAVA

