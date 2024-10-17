import { LogLevel, Configuration, BrowserCacheLocation } from '@azure/msal-browser';

const isIE = window.navigator.userAgent.indexOf("MSIE ") > -1 || window.navigator.userAgent.indexOf("Trident/") > -1;
 
export const b2cPolicies = {
     names: {
         signUpSignIn: "B2C_1_signupsignin1",
         editProfile: "B2C_1_profileediting1"
     },
     authorities: {
         signUpSignIn: {
             authority: "https://proyectoDeTitulo2024.b2clogin.com/proyectoDeTitulo2024.onmicrosoft.com/B2C_1_signupsignin1",
         },
         editProfile: {
             authority: "https://proyectoDeTitulo2024.b2clogin.com/proyectoDeTitulo2024.onmicrosoft.com/B2C_1_profileediting1"
         }
     },
     authorityDomain: "proyectoDeTitulo2024.b2clogin.com"
 };
 
 
export const msalConfig: Configuration = {
     auth: {
         clientId: '6cc185d2-aca1-412a-86f2-f850cfbc0bb9',
         authority: b2cPolicies.authorities.signUpSignIn.authority,
         knownAuthorities: [b2cPolicies.authorityDomain],
         redirectUri: '/', 
     },
     cache: {
         cacheLocation: BrowserCacheLocation.LocalStorage,
         storeAuthStateInCookie: isIE, 
     },
     system: {
         loggerOptions: {
            loggerCallback: (logLevel, message, containsPii) => {
                console.log(message);
             },
             logLevel: LogLevel.Verbose,
             piiLoggingEnabled: false
         }
     }
 }

export const protectedResources = {
  todoListApi: {
    endpoint: "http://localhost:5000/api/todolist",
    scopes: ["https://proyectoDeTitulo2024.onmicrosoft.com/tasks-api/tasks.read"],
  },
}
export const loginRequest = {
  scopes: []
};