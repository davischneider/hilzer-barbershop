William Stallings (Stallings, 2012) apresenta uma versão mais complicada do problema
da barbearia, que ele atribui a Ralph Hilzer da Universidade da Califórnia. O problema
consiste numa barbearia com três barbeiros e três cadeiras próprias de barbeiros,
também existe uma série de lugares para que os clientes possam esperar. Tanto os
barbeiros quanto os clientes devem ser implementados como Threads.

Requisitos:
1. três cadeiras;
2. três barbeiros;
3. uma sala de espera com um sofá de quatro lugares;
4. o número total de clientes permitidos na barbearia é 20;
5. nenhum cliente entrará se a capacidade do local estiver satisfeita;
6. se o cliente entrou e tiver lugar no sofá ele se senta, caso contrário ele espera em pé;
7. quando um barbeiro está livre para atender, o cliente que está a mais tempo no sofá é atendido e o que está a mais tempo em pé se senta;
8. qualquer barbeiro pode aceitar pagamento, mas somente um cliente pode pagar por vez, porque só há uma POS;
9. os barbeiros dividem o seu tempo entre cortar cabelo, receber pagamento e dormir enquanto esperam por um cliente.