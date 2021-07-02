package ordenacao;

public class ShellSort {
  
    public SellSort(int id, String nome){  
        super(id, nome);
    }

    @Override
    public List<String> ordenar(List<String> listaOrdenacao) {
        
        while (intervalo > 0) {
              for (int externo = intervalo; externo < comprimento; externo++) {
                  int valor = arr[externo];
                  int interno = externo;
                  while (interno > intervalo - 1 && arr[interno - intervalo] >= valor) {
                      arr[interno] = arr[interno - intervalo];
                      interno = interno - intervalo;
                  }
                  arr[interno] = valor;
              }
              intervalo = (intervalo - 1) / 3;
          }
          return arr;
      }
      public int CalcularIntervalo(int comprimento) {
          int intervalo = 0;
          while (intervalo < comprimento / 3) {
              intervalo = intervalo * 3 + 1;
          }
          return intervalo;
      }

}
    
    
    

