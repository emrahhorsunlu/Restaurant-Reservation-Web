document.addEventListener('DOMContentLoaded', function () {
    const reservationForm = document.getElementById('reservationForm');

    reservationForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = new FormData(reservationForm);

        const reservationData = {
            adSoyad: formData.get('name'),
            email: formData.get('email'),
            telefonNumarasi: formData.get('phone'),
            tarih: formData.get('date'),
            saat: formData.get('time'),
            kisiSayisi: parseInt(formData.get('people'))
        };

        axios.post('/api/reservations', reservationData)
            .then(function (response) {
                alert('Rezervasyon başarıyla yapıldı!');
                reservationForm.reset();
            })
            .catch(function (error) {
                alert('Rezervasyon yapılırken bir hata oluştu: ' + error.message);
            });
    });
});
