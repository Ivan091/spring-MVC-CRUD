import {createMuiTheme} from "@material-ui/core";

const theme = createMuiTheme({
    typography: {
        button: {
            textTransform: 'none'
        },
        navLink: {
            textDecoration: 'none'
        },
        fontFamily:
            '"Segoe UI","Roboto"',
    },
});

export default theme;