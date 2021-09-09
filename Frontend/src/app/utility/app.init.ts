import { KeycloakService } from 'keycloak-angular';

export function initializeKeycloak(
  keycloak: KeycloakService
): () => Promise<boolean> {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080' + '/auth',
        realm: 'vermeg',
        clientId: 'Move-client',
      },
      initOptions: {
        checkLoginIframe: true,
        checkLoginIframeInterval: 5,
      },
      loadUserProfileAtStartUp: true,
    });
}
