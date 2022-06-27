public class ProgDinamica {
    public int calculaTabela(Lamina lamina){
        int t1 = lamina.getEspessura()-4;
        int t2 = lamina.getEspessura()-4;
        int[][] tabela = new int[t1][t2];
        for(int i = 0; i < t1; i++){
            lamina.reduzirLamina(1);
            for(int j = 0; j<t2; j++) {
                if (j < i + 3) {
                    if (i == 0) {
                        if (j == 0) tabela[i][j] = lamina.getValorReducao1();
                        else if (j == 1) tabela[i][j] = lamina.getValorReducao2();
                        else tabela[i][j] = lamina.getValorReducao3();
                    } else {
                        if (i > j) {
                            tabela[i][j] = tabela[i - 1][j];
                        } else {
                            if (i == j) {
                                if (lamina.getValorReducao1() + tabela[i][j - 1] < tabela[i - 1][j])
                                    tabela[i][j] = lamina.getValorReducao1() + tabela[i][j - 1];
                                else tabela[i][j] = tabela[i - 1][j];
                            } else if (i + 1 == j) {
                                if (lamina.getValorReducao2() + tabela[i][j - 2] < tabela[i - 1][j])
                                    tabela[i][j] = lamina.getValorReducao2() + tabela[i][j - 2];
                                else tabela[i][j] = tabela[i - 1][j];
                            } else if (i + 2 == j) {
                                if (lamina.getValorReducao3() + tabela[i][j - 3] < tabela[i - 1][j])
                                    tabela[i][j] = lamina.getValorReducao3() + tabela[i][j - 3];
                                else tabela[i][j] = tabela[i - 1][j];
                            }
                        }
                    }
                } else {
                    tabela[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        lamina.setCusto(tabela[t1-1][t2-1]);
        return lamina.getCusto();

    }
}
