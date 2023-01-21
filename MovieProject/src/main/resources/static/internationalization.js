$(document).ready(function() {
  $("#locales").change(function () {
    var selectedOption = $('#locales').val();
    if (selectedOption != ''){
      if (!isNaN(selectedOption)) {
        selectedOption = parseInt(selectedOption);
      }
      var currentUrl = window.location.pathname;
      var newUrl = currentUrl + '?lang=' + selectedOption.toString();
      window.location.replace(newUrl);
    }
  });
});