import { Etat } from './etat';
import { Collaborateur } from './collaborateur';
import { Itineraire } from './itineraire';
export class Deplacement {
  id!: number;
  villeDepart!: string;
  villeArrivee!: string;
  dateDepart!: Date;
  dateRetour!: Date;
  etat!: Etat;
  notice!: string;
  remuneration!: number;
  Collaborateur!: Collaborateur;
  itineraire!: Itineraire[];
}
