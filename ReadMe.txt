### Projeto feito com o Spring Initializr
- Maven Project
- Sprint Boot 2.7.3

# Project Metada
- Group: br.com.wbraga
- Artifact: desafio-alura
- Package Name: br.com.wbraga.desafio-alura

# Packaging
- Jar

# Java: 
- Java 11

# Depedencias
- PostgreSQL Driver 
- Spring Security
- Spring Web 
- Spring Data JPA
- H2 Database
- Spring Reactive Web

### Hospedagem Deploy
- Heroku

### Banco de dados
#  TESTE 
- H2

# Banco de dados Postgre 
- Heroku - free


=================================================
 ###  Modelagem  ####

# Pacote 'entities' com os tipos; cria dados no banco
Anotações utilizadas
@Entity   - Marca a classe como um Entidade 
@Table(name= "tb_despesas") - Marca como uma tabela no banco de dados

@Id  - Marca como ID - chave primario no banco e autonumeração
@GeneratedValue(strategy = GenerationType.IDENTITY)

# Pacote  Repositorios 
- Interface - fara o papel dos Cruds pelo JPA SprintBoot
-- extends JpaRepositoryImplementation (Não precisa de anotação conta desta implementação)
-- Recebe a Classse e tipo Long (ID do objeto)

# Pacote Services
@Service  - Marcar que é serviço 
@Autowired - Faz a injeção e controles de depencias (Não precia instaciar os objeots)


# Pacote Reouserces
@RestController  - Diz que é o controle. 
@RequestMapping(value = "/users")Nossos endPoints

#
