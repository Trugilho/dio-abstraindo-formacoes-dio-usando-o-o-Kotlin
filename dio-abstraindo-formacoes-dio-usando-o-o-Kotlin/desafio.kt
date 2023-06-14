enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) {
            if (!inscritos.contains(aluno)) {
                inscritos.add(aluno)
                println("Aluno ${aluno.nome} matriculado em $nome.")
            } else {
                println("Aluno ${aluno.nome} já está matriculado em $nome.")
            }
        }
    }

    fun listarInscritos() {
        println("Alunos inscritos na formação $nome:")
        for (aluno in inscritos) {
            println(aluno.nome)
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("JavaScript Avançado", 560)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 850)
    val conteudo3 = ConteudoEducacional("Linguagem Programação Android", 345)

    val formacao = Formacao("Formação Front-end Web", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    val aluno1 = Aluno("Pedro")
    val aluno2 = Aluno("Clarisse")
    val aluno3 = Aluno("Maria")

    formacao.matricular(aluno1) 
    formacao.matricular(aluno2) 
    formacao.matricular(aluno1) 
    formacao.matricular(aluno3) 

    formacao.listarInscritos()
}
