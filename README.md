# Battery Charge Time Calculator

Battery Charge Time Calculator é um aplicativo Android que calcula o tempo necessário para carregar uma bateria com base na capacidade da bateria, carga atual, corrente de carga e tensão de entrada.

## Funcionalidades

- **Cálculo do Tempo de Carregamento**: Insira a capacidade da bateria, a carga atual, a corrente de carga e a tensão de entrada para calcular o tempo necessário para carregar a bateria.
- **Alternar Tema**: Mude entre o modo claro e escuro usando o botão no canto inferior esquerdo.
- **Compartilhar Resultado**: Compartilhe o resultado do cálculo com outros aplicativos.
- **Histórico**: Acesse o histórico de cálculos realizados.
- **Ajuda**: Veja informações sobre como usar o aplicativo.

## Estrutura do Projeto

BatteryChargerV3/ 
├── app/ 
│ ├── src/ 
│ │ ├── main/ 
│ │ │ ├── java/com/example/batterychargerv3/ 
│ │ │ │ ├── MainActivity.kt 
│ │ │ │ ├── HistoryActivity.kt 
│ │ │ │ ├── HelpActivity.kt 
│ │ │ ├── res/ 
│ │ │ │ ├── layout/ 
│ │ │ │ │ ├── activity_main.xml 
│ │ │ │ │ ├── activity_history.xml 
│ │ │ │ │ ├── activity_help.xml 
│ │ │ │ ├── values/ 
│ │ │ │ │ ├── strings.xml 
│ │ │ │ │ ├── colors.xml 
│ │ │ │ │ ├── themes.xml 
│ │ │ │ ├── drawable/ 
│ │ │ │ │ ├── ic_sun.xml 
│ │ │ │ │ ├── ic_moon.xml 
│ │ │ │ │ ├── ic_share.xml 
│ │ │ │ │ ├── edit_text_background.xml


## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/talleshts/BatteryChargerCalculator-app.git
    ```

2. Abra o projeto no Android Studio.

3. Conecte um dispositivo Android ou inicie um emulador.

4. Compile e execute o aplicativo.

## Uso

1. **Cálculo do Tempo de Carregamento**:
    - Insira a capacidade da bateria (em kW).
    - Insira a carga atual da bateria (em %).
    - Selecione a corrente de carga (em A).
    - Selecione a tensão de entrada (em V).
    - Toque no botão "Calcular" para ver o tempo de carregamento estimado.

2. **Alternar Tema**:
    - Toque no ícone de sol/lua no canto inferior esquerdo para alternar entre o modo claro e escuro.

3. **Compartilhar Resultado**:
    - Toque no ícone de compartilhar no canto inferior direito para compartilhar o resultado do cálculo.

4. **Histórico**:
    - Toque no botão "Histórico" para ver o histórico de cálculos realizados.

5. **Ajuda**:
    - Toque no botão "Ajuda" para ver informações sobre como usar o aplicativo.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/nova-feature`).
5. Crie um novo Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato

- **Nome**: Talles Henrique Teófilo dos Santos
- **Email**: talles0h@gmail.com
- **GitHub**: [talleshts](https://github.com/Talleshts)
