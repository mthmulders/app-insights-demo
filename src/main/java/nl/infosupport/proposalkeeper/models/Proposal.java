package nl.infosupport.proposalkeeper.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines a single proposal
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proposals")
public class Proposal {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String title;
    private String description;
}
