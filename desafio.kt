enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Aluno>()

    fun matricularAluno(aluno: Aluno) {
        inscritos.add(aluno)
        println("Aluno ${aluno.nome} matriculado na formação $nome")
    }

    fun matricularAlunos(alunos: List<Aluno>) {
        inscritos.addAll(alunos)
        alunos.forEach { aluno ->
            println("Aluno ${aluno.nome} matriculado na formação $nome")
        }
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 180)

    // Criando uma formação
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    // Criando alguns alunos
    val aluno1 = Aluno("João")
    val aluno2 = Aluno("Maria")

    // Matriculando os alunos na formação
    formacaoKotlin.matricularAluno(aluno1)
    formacaoKotlin.matricularAluno(aluno2)

    // Lista de alunos para matricular de uma vez
    val novosAlunos = listOf(Aluno("Pedro"), Aluno("Laura"), Aluno("Lucas"))
    formacaoKotlin.matricularAlunos(novosAlunos)
    
    for (aluno in formacaoKotlin.inscritos) {
        println(aluno.nome)
    }
    
    println(formacaoKotlin.nivel)
    println(formacaoKotlin.conteudos)
}