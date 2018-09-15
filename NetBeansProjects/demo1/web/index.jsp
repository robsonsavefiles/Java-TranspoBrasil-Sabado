<html>
    <head>
        <title>Exemplo AJAX</title>
    </head>
    <script type="text/javascript">
          var request;
  
          function sendRequest() {
  
          //Determina o estado selecionado
          combo = document.getElementById("estado");
          estado = combo.options[combo.selectedIndex].value;
  
          //Retorna quando nenhum estado for selecionado
          if(estado == "-1")
              return;
  
          //Monta a url de requisicao para o servidor
          url = "cadastrarCliente?action=preencherCidades&estado="
                + estado;
 
          //Inicializa o objeto XMLHttpRequest para o Mozilla
          if ( window.XMLHttpRequest ) {
              request = new XMLHttpRequest();
          }

         //Inicializa o objeto XMLHttpRequest para o Internet Explorer
          else if (window.ActiveXObject) {
              request = new ActiveXObject("Microsoft.XMLHTTP");
          }
  
          //determina a função para processamento da requisição
          request.onreadystatechange = processRequest;
  
          //configura a requisição
          request.open("GET",url,true);
  
          //envia a requisição
          request.send(null);
          }
  
          function processRequest() {
              //Verifica se a resposta já foi recebida por completo
              if(request.readyState == 4) {
              //Verifica se o status é OK
                  if(request.status == 200) {
                      //Faz a leitura do documento XML recebido
                      var response = request.responseXML;
                      var raiz =
                      response.getElementsByTagName("cidades").item(0);
                      var cidades = raiz.getElementsByTagName("cidade");
  
                      //Seleciona a caixa de selecao de cidades
                      var selectNode = document.getElementById("cidade");
  
                      //Apaga as opções atuais da caixa de seleção
                      selectNode.options.length = 0;
  
                      //preenche a caixa de opções com os valores recebidos
                      for(var i = 0; i < cidades.length; i++) {
                          var txtCidade = cidades.item(i).firstChild.data;
                          var option = new Option(txtCidade);
                          selectNode.add(option,null);
                      }
                  }
              }
          }
    </script>    
    <body>
        <h1>Cadastro de Clientes</h1>
        <form action='<%=request.getContextPath()+"/cadastrarCliente"%>'
              method='post'>
            <fieldset><legend>Dados do cliente</legend>
                <table>
                    <tr>
                        <td><label for='nome'>Nome:</label></td>
                        <td colspan='3'>
                            <input name='nome' id='nome' type='text'
                                   size='75' maxlength='255'></input>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='telefone'>Telefone: (0000-0000)
                            </label>
                        </td>
                        <td><input name='telefone' id='telefone'
                                       type='text' size='16'></input>
                        </td>
                        <td><label for='email'>e-mail:</label>
                        </td>
                        <td><input name='email' id='email' type='text'
                                       size='37'></input>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend></legend>
                <table>
                    <tr>
                        <td><label for='endereco'>Rua/Av:</label></td>
                        <td><input name='rua' id='rua' type='text'
                                       size='40' maxlength='255'></input>
                        </td>
                        <td><label for='numero'>Número:</label></td>
                        <td><input name='numero' id='numero' type='text'
                                       size='8' maxlength='5'></input>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='bairro'>Bairro:</label></td>
                        <td><input name='bairro' id='bairro' type='text'>
                            </input>
                        </td>
                        <td><label for='cep'>CEP (00000-000):</label>
                        </td>
                        <td><input name='cep' id='cep' type='text'
                                       size='8'></input>
                        </td>
                    </tr>                    
                    <tr>
                        <td><label for='estado'>Estado:</label></td>
                        <td>
                            <select name='estado' id='estado'
                                    onchange='sendRequest();'>
                                <option value='-1'>Escolha um estado
                                </option>
                                <option value='MG'>MG</option>
                                <option value='SP'>SP</option>
                                <option value='RJ'>RJ</option>
                            </select>
                        </td>
                        <td>
                            <label for='cidade'>Cidade:</label>
                        </td>
                        <td><select name='cidade' id='cidade'
                                        style="width:200px"></select>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <input type='submit' value="Salvar"></input>
        </form>
    </body>
</html>

