package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.NFSePedidoCancelamento;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;

public class NFSeCancelamentoTest {

  @Test
  public void deveGerarXmlCancelamentoCorretamente() throws IOException{
    NFSePedidoCancelamento pedido = new NFSePedidoCancelamento(FabricaDeObjetosFake.getNFSeInfPedidoCancelamento());
    NFSeCancelamento nfseCancelamento = new NFSeCancelamento(pedido);
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("identificacaoNFSe.xml"));
    String xml = nfseCancelamento.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isIdenticalTo(xmlTest));
  }
  
}


