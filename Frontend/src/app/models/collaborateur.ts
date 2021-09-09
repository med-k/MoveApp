import { Passeport } from './passeport';
import { Role } from './role';
import { Adresse } from './adresse';
export class Collaborateur {
  id!: number;
  prenom!: string;
  nom!: string;
  email!: string;
  numTel!: String;
  cin!: string;
  adresse!: Adresse;
  role!: Role;
  superviseur!: Collaborateur;
  passeport: Passeport[] = [];
}
