package com.kmachuramika.eprzychodnia.web.restapi;

import com.kmachuramika.eprzychodnia.model.Patient;
import com.kmachuramika.eprzychodnia.service.PatientService;
import com.kmachuramika.eprzychodnia.web.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/patients")
@Tag(name="Pacjenci")
public class PatientController {

    private final PatientService patientService;

    @Operation(summary = "Lista pacjentów")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista pacjentów została znaleziona"),
            @ApiResponse(responseCode = "400", description = "Złe zapytanie", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "Odmowa dostępu", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono pacjentów", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Konflikt", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "412", description = "Warunek wstępny nie powiódł się", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Wysłano niepoprawne wartości pól, np. walidacja obiektu zwróciła błąd, albo któreś z pól nie spełnia kryteriów nałożonych na nie przez zasób", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content=@Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }


}
