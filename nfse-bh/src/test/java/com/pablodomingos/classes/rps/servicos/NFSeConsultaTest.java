package com.pablodomingos.classes.rps.servicos;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import java.io.IOException;
import java.time.LocalDate;

public class NFSeConsultaTest {

  @Test
  public void xmlDeveSerGeradoCorretamente() throws IOException{
    String xmlTest = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("consultaNFSe.xml"));
    NFSeConsulta consultaNFSe = new NFSeConsulta(FabricaDeObjetosFake.getRpsPrestador(), LocalDate.of(2017, 01, 12), LocalDate.of(2017, 01, 12));
    String xml = consultaNFSe.converterParaXml();
    Assert.assertThat(xml, CompareMatcher.isSimilarTo(xmlTest).normalizeWhitespace().ignoreWhitespace());
  }
  
}


