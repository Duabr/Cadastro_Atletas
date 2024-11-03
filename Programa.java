package exemplo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int quantiPessoas;
		List<String> listaNome = new ArrayList<>();
		List<String> listaSexo = new ArrayList<>();
		List<Double> listaAltura = new ArrayList<>();
		List<Double> listaPeso = new ArrayList<>();
		double pesoTotal = 0;
		double maiorAltura = 0;
		int indiceMaiorAltura = 0;

		System.out.printf("Quantos atletas deseja cadastrar? ");
		quantiPessoas = scanner.nextInt();
		int numHomens = 0;
		int numMulheres = 0;
		double totalAlturaMulheres = 0;

		System.out.println("Use vírgula ao invés de ponto para casas decimais.");
		for (int i = 0; i < quantiPessoas; i++){
			scanner.nextLine();
			System.out.printf("Digite os dados do %dº atleta:\n", i+1);
			System.out.printf("Nome: ");
			String nome = scanner.nextLine();
			listaNome.add(nome);

			System.out.printf("Sexo (M ou F): ");
			String sexo = scanner.next();
			while (!sexo.equals("f") && !sexo.equals("m")) {
				System.out.printf("Valor Inválido! Digite M ou F: ");
				sexo = scanner.next();
			}
			listaSexo.add(sexo);
			if (sexo.equals("m")){
				numHomens++;
			}

			System.out.printf("Altura (em metros): ");
			double altura = scanner.nextDouble();
			while (altura <= 0){
				System.out.printf("Por favor, digite um número positivo: ");
				altura = scanner.nextDouble();
			}
			listaAltura.add(altura);
			if (altura > maiorAltura){
				maiorAltura = altura;
				indiceMaiorAltura = i;
			}
			if (sexo.equals("f")){
				numMulheres++;
				totalAlturaMulheres += altura;
			}

			System.out.printf("Peso (em quilogramas): ");
			double peso = scanner.nextDouble();
			while (peso <= 0){
				System.out.printf("Por favor, digite um número positivo: ");
				peso = scanner.nextDouble();
			}
			pesoTotal += peso;
			listaPeso.add(peso);
			
			
		}

		double porcentagemHomens = ((double) numHomens/quantiPessoas) * 100;

		System.out.println("\n### RELATÓRIO ###");
		System.out.printf("Peso médio dos atletas: %.2f\n", pesoTotal/quantiPessoas);
		System.out.printf("O/A atleta mais alto(a) se chama %s, com %.2fm de altura.\n", listaNome.get(indiceMaiorAltura), maiorAltura);
		System.out.printf("%.2f%% dos atletas são homens.\n", porcentagemHomens);
		if (numMulheres>0){
			System.out.printf("A altura média das mulheres é de %.2fm.\n", totalAlturaMulheres/numMulheres);
		}
		else{
			System.out.println("Não há nenhuma mulher cadastrada, então a altura média de mulheres não pôde ser calculada.");
		}
		

		// for (int i = 0; i < quantiPessoas; i++){
		// 	System.out.printf("Nome: %s\n", cadastro.nome.get(i));
		// 	System.out.printf("Sexo: %s\n", cadastro.sexo.get(i));
		// 	System.out.printf("Altura : %f\n", cadastro.altura.get(i));
		// 	System.out.printf("Peso: %f\n", cadastro.peso.get(i));
		// }

		
		scanner.close();
	}
		
	
}
