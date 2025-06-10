package com.clinica.medica.services;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.medica.entities.Consultas;
import com.clinica.medica.entities.Medico;
import com.clinica.medica.repositories.ConsultaRepository;
import com.clinica.medica.repositories.MedicoRepository;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class RelatorioConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public byte[] gerarPdfRelatorioPorMedico(Long medicoId) throws DocumentException {
        Optional<Medico> medicoOpt = medicoRepository.findById(medicoId);

        String nomeMedico = medicoOpt.map(Medico::getNome).orElse("Médico não encontrado");
        String especialidadeMedico = medicoOpt.map(Medico::getEspecialidade).orElse("Especialidade não informada");

        List<Consultas> listaConsultas = consultaRepository.findByMedicoId(medicoId);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(); 
        PdfWriter.getInstance(document, out);
        document.open();

        
        document.add(new Paragraph("Relatório de Consultas do Profissional"));
        document.add(new Paragraph("Nome: " + nomeMedico));
        document.add(new Paragraph("Especialidade: " + especialidadeMedico));
        document.add(new Paragraph("Total de Consultas: " + listaConsultas.size()));
        document.add(new Paragraph(" "));

      
        for (Consultas consulta : listaConsultas) {
            String data = (consulta.getDataConsulta() != null)
                    ? consulta.getDataConsulta().toString()
                    : "Data não informada";

            String paciente = (consulta.getPaciente() != null && consulta.getPaciente().getNome() != null)
                    ? consulta.getPaciente().getNome()
                    : "Paciente não informado";

            document.add(new Paragraph("Data: " + data + " | Paciente: " + paciente));
        }

        document.close();
        return out.toByteArray();
    }
}