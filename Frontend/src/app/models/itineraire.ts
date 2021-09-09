import { ModeTransport } from './modeTransport';

export class Itineraire {
  id!: number;
  billet!: string;
  modeTransport!: ModeTransport;
  heureDepart!: string;
  heureArrivee!: string;
  pointDepart!: string;
  pointArrivee!: string;
}
